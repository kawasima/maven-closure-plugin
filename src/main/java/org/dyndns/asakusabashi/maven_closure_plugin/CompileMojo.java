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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import com.google.javascript.jscomp.CompilerRunner;

import java.util.ArrayList;
import java.util.List;

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
    	for(PackagingSet packagingSet : packagingSets) {
    		List<String> options = new ArrayList<String>();
    		for(String include : packagingSet.getIncludes()) {
    			options.add("--js");
    			options.add(include);
    		}
    		options.add("--js_output_file");
    		options.add(packagingSet.getOutputFile().getPath());
    		CompilerRunner.main(options.toArray(new String[0]));
    	}
    }
}
