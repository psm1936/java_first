package kr.smhrd.web;

import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.smhrd.domain.AttachFileVO;

@Controller
public class UploadController {

	// String의 경우 리턴값이 view의 이름으로 사용한다.
	// void의 경우 RequestToViewNameResolver를 통해 자동생성되는 View 이름이 사용된다. URL과 View 이름을
	// 통일하여 사용해야한다.

	@GetMapping("/uploadForm.do")
	public void uploadForm() {
		// void이면서 return도 안할 경우 -> uploadForm.jsp으로 이동
	}

	@PostMapping("/uploadFormAction.do")
	public void uploadFormAction(MultipartFile[] uploadFile, Model model) {

		List<AttachFileVO> list = new ArrayList<AttachFileVO>();

		String uploadFolder = "C:\\upload";
		String uploadFolderPath = getFolder(); // 2021\07\27
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs(); // 디렉토리 생성
		}

		for (MultipartFile multipartFile : uploadFile) {
			System.out.print(multipartFile.getOriginalFilename() + ":");
			System.out.println(multipartFile.getSize());

			AttachFileVO vo = new AttachFileVO();

			String uploadFileName = multipartFile.getOriginalFilename();
			vo.setFileName(uploadFileName); // 0

			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;

			File saveFile = new File(uploadPath, uploadFileName);
			try {
				multipartFile.transferTo(saveFile);
				vo.setUuid(uuid.toString()); // 0
				vo.setUploadPath(uploadFolderPath);// 0
				list.add(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("list", list);// 객체바인딩
	}

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", "/");
	}

	// MiME TYPE(application.octet-stream)
	@GetMapping(value = "/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	//@ResponseBody // download.jsp로 가지않음
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName) {
		// System.out.println(fileName);

		Resource resource = new FileSystemResource("C:\\upload\\" + fileName);
		String resourceName = resource.getFilename();

		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

		// 다운로드 작업
		HttpHeaders headers = new HttpHeaders();
		
		// 한글로 나오게 하는 부분인데 왜 안되는지 모르겠다.
		try {
			String downloadName = null;
			if (userAgent.contains("Trident")) {
				System.out.println("IE");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			} else if (userAgent.contains("Edge")) {
				System.out.println("Edge");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
			} else {
				System.out.println("Chrome");
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}

			headers.add("Content-Disposition", "attachment;filename=" + resourceOriginalName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK); // ajax 형식적으로 지금은 맞춰논거

	}

}
