package instructions;

import virtualMachine.Flow;
import virtualMachine.Memory;
import virtualMachine.VirtualMachine;

public class QDUMP_Instruction implements Instruction {
	
	private String arg;

	@Override
	public void execute(Flow f) throws Exception {
		Memory mem = VirtualMachine.getInstance().getMemory();
		mem.showMemLocation(mem.getRegisterAddress(arg), 16);
		f.setIndex(f.getIndex() + 1);
	}

	@Override
	public String getName() {
		return "QDUMP";
	}

	@Override
	public void initialize(String text) {
		String[] parsed = text.split(" ");
		arg = parsed[1];
	}
}
