package dev.zihasz.clientbase.util.utils.client;

import dev.zihasz.clientbase.util.Util;
import org.reflections.Reflections;

import java.util.Set;

public class ReflectionUtils extends Util {

	public static Set<Class> findClasses(String pack, Class subType) {
		Reflections reflections = new Reflections(pack);
		return reflections.getSubTypesOf(subType);
	}

}
