package io.meister;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FactoryLoader {
    public static Map<Character, FigureFactory> load(){
        Set<Class<? extends FigureFactory>> classes = findAvailableClasses();
        return createMap(classes);
    }

    private static Map<Character, FigureFactory> createMap(Set<Class<? extends FigureFactory>> classes) {
        Map<Character, FigureFactory> figureFactoryMap = new HashMap<Character, FigureFactory>();
        for (Class<? extends FigureFactory> current_class : classes){
            put(current_class, figureFactoryMap);
        }
        return figureFactoryMap;
    }

    private static void put(Class<? extends FigureFactory> current_class, Map<Character, FigureFactory> figureFactoryMap) {
        try{
            FigureFactory figureFactory = (FigureFactory) current_class.getConstructor().newInstance();
            figureFactoryMap.put(figureFactory.getKeyChar(), figureFactory);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static Set<Class<? extends FigureFactory>> findAvailableClasses() {
        Reflections reflections = new Reflections("io.meister.figure.factories");
        return reflections.getSubTypesOf(FigureFactory.class);
    }
}
