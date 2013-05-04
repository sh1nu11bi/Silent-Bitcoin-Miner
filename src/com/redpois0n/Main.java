package com.redpois0n;

import com.diablominer.DiabloMiner.DiabloMiner;

public class Main {

	public static void main(String[] args) throws Exception {
		Natives.writeNatives();
		
		DiabloMiner.main(args);
	}

}
