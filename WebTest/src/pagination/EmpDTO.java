package pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpDTO {
	private int eno;
	private String ename;
	private int rn;
	
	@Override
	public String toString() {
		return "EmpDTO [eno=" + eno + ", ename=" + ename + ", rn=" + rn + "]";
	}
	
	
}
