package instructions;
import virtualMachine.Flow;
import virtualMachine.Memory;
import virtualMachine.VirtualMachine;


public class EQ_Instruction implements Instruction {

	private String arg1, arg2;
	private String result;

	@Override
	public void execute(Flow f) throws Exception {
		Memory mem = VirtualMachine.getInstance().getMemory();
		int r1 = mem.getRegValue(arg1);
		int r2 = mem.getRegValue(arg2);
		int r3 = (r1 == r2) ? 1 : 0;			
		mem.setRegValue(result, r3);
		f.setIndex(f.getIndex() + 1);
	}

	@Override
	public String getName() {
		System.out.println("EQ " + arg1 + " " + arg2 + " " + result);
		return "EQ";
	}

	@Override
	public void initialize(String text) {
		String[] parsed = text.split(" ");
		arg1 = parsed[1];
		arg2 = parsed[2];
		result = parsed[3];
	}

}