package org.dyndns.asakusabashi.maven_closure_plugin;

import java.io.File;

public class PackagingSet {
	private String[] externs;
	
	private String[] includes;
	
	private File outputFile;
	
	public String[] getExterns() {
		return externs;
	}

	public void setExterns(String[] externs) {
		this.externs = externs;
	}

	public String[] getIncludes() {
		return includes;
	}

	public void setIncludes(String[] includes) {
		this.includes = includes;
	}

	public File getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}
}
