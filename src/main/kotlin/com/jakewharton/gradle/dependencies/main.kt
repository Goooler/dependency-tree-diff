@file:JvmName("DependencyTreeDiff")

package com.jakewharton.gradle.dependencies

import java.nio.file.Paths
import kotlin.io.path.readText
import kotlin.system.exitProcess

fun main(vararg args: String) {
	val help = "-h" in args || "--help" in args
	if (help || args.size != 2) {
		System.err.println("Usage: dependency-tree-diff old.txt new.txt")
		if (!help) {
			exitProcess(1)
		}
		return
	}

	val old = args[0].let(Paths::get).readText()
	val new = args[1].let(Paths::get).readText()

	print(dependencyTreeDiff(old, new))
}
