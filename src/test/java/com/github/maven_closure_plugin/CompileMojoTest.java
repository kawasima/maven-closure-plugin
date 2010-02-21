package com.github.maven_closure_plugin;

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;

import com.github.maven_closure_plugin.CompileMojo;
import com.github.maven_closure_plugin.PackagingSet;

import junit.framework.TestCase;


public class CompileMojoTest extends TestCase{
	public void setUp() {
		new File("target/compile_test").mkdirs();
	}
	public void test_compile() {
		CompileMojo mojo = new CompileMojo();
		mojo.packagingSets = new PackagingSet[1];
		mojo.packagingSets[0] = new PackagingSet();
		mojo.packagingSets[0].setOutputFile(new File("target/compile_test/sets0.min.js"));
		mojo.packagingSets[0].setIncludes(new String[] {
				"src/test/resources/test1.js",
				"src/test/resources/test2.js"
		});
		
		try {
			mojo.execute();
		} catch (MojoExecutionException e) {
			fail(e.getLongMessage());
		}
	}

}
