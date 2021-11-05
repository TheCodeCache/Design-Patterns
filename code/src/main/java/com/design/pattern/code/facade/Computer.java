package com.design.pattern.code.facade;

/* Complex parts */

class CPU {
	public void freeze() {
		// freeze impl.
	}

	public void jump(long position) {
		// jump impl.
	}

	public void execute() {
		// exec impl.
	}
}

class Memory {
	static long BOOT_ADDRESS;

	public void load(long position, byte[] data) {
		// implement load from RAM
	}
}

class HardDrive {
	static long BOOT_SECTOR;
	static int SECTOR_SIZE;

	public byte[] read(long lba, int size) {
		// implement read from disk
		return null;
	}
}

/**
 * Computer Facade
 * 
 * @author manoranjan
 */

class Computer {
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.hardDrive = new HardDrive();
	}

	/**
	 * abstracting the underlying complexities and exposing a simple API i.e.
	 * "startComputer"
	 */
	public void startComputer() {
		cpu.freeze();
		memory.load(Memory.BOOT_ADDRESS, hardDrive.read(HardDrive.BOOT_SECTOR, HardDrive.SECTOR_SIZE));
		cpu.jump(Memory.BOOT_ADDRESS);
		cpu.execute();
	}
}
