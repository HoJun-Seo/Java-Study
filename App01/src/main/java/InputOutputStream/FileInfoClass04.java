package InputOutputStream;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class FileInfoClass04 {

	public static void main(String[] args) {
		
		String sPath = "C:"+File.separator+"Users"+
				File.separator+"tnrdu"+File.separator+"Documents"
				+ File.separator + "GitHub" + File.separator + "Java-Study"
				+ File.separator + "App01";
		//String path2 = "C:\\myjava\\javawork\\App01";
		//sPath => String(문자열) , new File(sPath) => 시스템에서 인식하는 파일경로
		String files[] = new File(sPath).list();
		Arrays.stream(files).forEach(x->System.out.printf(" %s \n", x));
		System.out.println("----");
		
		// 디렉터리(폴더) filter식 수지( 함수형 인터페이스 작성)
		// 문자열을 입력 -> 시스템파일로 인식 -> 디렉토리인지 판별(true)
		Predicate<String> dirCondition = x -> {
			File fileDir = new File(x);
			return fileDir.isDirectory();
		};
		// 디렉토리(폴더) 이름만 필터링
		List<String> dirList = Arrays.stream(files)
									 .filter(dirCondition)//// 디렉토리 판별 함수 호출
									 .map(x ->  "[" + x +"]")
									 .collect(toList());
		//System.out.println(dirList);
		dirList.forEach(System.out::println);
		
		// 파일 filter식 작성
		Predicate<String> fileCondition = Predicate.not(dirCondition);
		
		// 파일 이름만 필터링
		List<String> fileList = Arrays.stream(files)
								.filter(fileCondition)// 파일이름이 파일시스템인 것만 필터링
								.map(file -> {
									File f = new File(file);
									file += (f.canExecute())? "\t(실행파일":"\t실행불가";
									file += (f.canRead())? 	"\t읽기가능":"\t읽기불가";
									file += (f.canWrite())? "\t쓰기가능":"\t쓰기불가";
									file += (f.isHidden())? "\t숨김파일":"\t일반파일)" ;
									return file;
								})
								.collect(toList());
		
		System.out.println("---");
		//fileList.forEach(System.out::println);
		
		Stream.of(dirList, fileList)
			  .flatMap(List::stream)
			  .forEach(System.out::println);
		
		
	}

}
//"file.txt"(String)=>File(file.txt)=> 파일시스템으로 인식
// a += (b>10) ? 100: 200;
