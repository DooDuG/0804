import java.util.Scanner;

import Main.DTO.RegisterRequest;
import Main.service.MemberLsitPrinter;
import Main.service.MemberRegisterService;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {		
		System.out.println("명령어를 입력하세요:");
		String command = sc.nextLine();
		if(command.startsWith("new")) {
			String[] arg = command.split(" ");
			if(arg.length != 5) {
				printHelp();
			System.out.println();
			continue;
			}
			RegisterRequest req = new RegisterRequest();
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl = req.isPasswordEqualConfurmPassword();
				if (!bl) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
			
				MemberRegisterService mrs = new MemberRegisterService();
				mrs.regist(req);
		}else if(command.startsWith("change")) {
			System.out.println("변경");
		}else if(command.startsWith("list")) {
			MemberLsitPrinter listPrint = new MemberLsitPrinter();
			listPrint.printAll();
			
			System.out.println("리스트");
		}else if(command.startsWith("info ")) {
			System.out.println("변경");
		}else if(command.startsWith("exit")) {
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		
		}
		}
		//클래스안에 있는 객체 ==>( 의존객체 - dependency object)
		
		}

	public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 이메일");
	}

}
