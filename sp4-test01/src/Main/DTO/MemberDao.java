package Main.DTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;
	private static Map<String,MemberDTO> map=
			new HashMap<String,MemberDTO>();
	public Collection<MemberDTO> selectAll(){
		return map.values();
	}
	public void insert(MemberDTO dto) {
		dto.setId(++nextId);
		map.put(dto.getEmail(), dto);
	}
	public MemberDTO selectByEmail(String email) {
		// TODO Auto-generated method stub
		return map.get(email);
	}
}
