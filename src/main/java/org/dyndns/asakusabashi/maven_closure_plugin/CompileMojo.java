package org.dyndns.asakusabashi.maven_closure_plugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.JSSourceFile;

/**
 * compile javascripts by Google Closure Compiler
 *
 * @goal compile 
 */
public class CompileMojo
    extends AbstractMojo
{
    /**
     * Compile and Packaging Srouces
     * @parameter
     */
    protected PackagingSet[] packagingSets;

    public void execute()
        throws MojoExecutionException
    {
    	Compiler compiler = new Compiler();

    	for(PackagingSet packagingSet : packagingSets) {
    		List<JSSourceFile> inputs = new ArrayList<JSSourceFile>();
    		if (packagingSet.getIncludes() != null) {
    			for(String include : packagingSet.getIncludes()) {
    				JSSourceFile newFile = JSSourceFile.fromFile(include);
    				inputs.add(newFile);
    			}
    		}
    		
    		List<JSSourceFile> externs = new ArrayList<JSSourceFile>();
    		if (packagingSet.getExterns() != null) {
    			for(String extern : packagingSet.getExterns()) {
    				JSSourceFile newFile = JSSourceFile.fromFile(extern);
    				externs.add(newFile);
    			}
    		}
    		
    		CompilerOptions options = new CompilerOptions();
    		options.jsOutputFile = packagingSet.getOutputFile().getPath();
    		compiler.compile(
    				  externs.toArray(new JSSourceFile[0])
    				, inputs.toArray(new JSSourceFile[0])
    				, options);
    	}
    }
}
