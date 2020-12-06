package com.esisa.java.io.app02;

import com.esisa.java.io.app02.models.DiskComponent;
import com.esisa.java.io.app02.models.File;
import com.esisa.java.io.app02.models.Folder;

public class DiskManager {
	private DiskComponent root;

	public DiskManager(String path) {
		root = createComponent(new java.io.File(path));
	}
	
	public DiskComponent createComponent(java.io.File f) {
		if(f.isFile()) {
			return new File(f.getName(), f.length());
		}
		else {
			Folder folder = new Folder(f.getName());
			java.io.File content[] = f.listFiles();
			for (int i = 0; i < content.length; i++) {
				DiskComponent cmp = createComponent(content[i]);
				folder.addChild(cmp);
				cmp.setParent(folder);
			}
			return folder;
		}
	}
	
	public DiskComponent getRoot() {
		return root;
	}

}
