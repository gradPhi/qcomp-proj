package instructions;
import virtualMachine.Flow;
import virtualMachine.Memory;
import virtualMachine.VirtualMachine;


public class POP_Instruction implements Instruction {
	
	private String arg;

	@Override
	public void execute(Flow f) throws Exception {
		Memory mem = VirtualMachine.getInstance().getMemory();
		mem.pop(arg);
		f.setIndex(f.getIndex() + 1);	
	}

	@Override
	public String getName() {
		System.out.println("POP " + arg);
		return "POP";
	}

	@Override
	public void initialize(String text) {
		String[] parsed = text.split(" ");
		arg = parsed[1];
	}

}
