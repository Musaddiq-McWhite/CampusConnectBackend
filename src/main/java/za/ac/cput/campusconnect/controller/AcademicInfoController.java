package za.ac.cput.campusconnect.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.AcademicInfo;
import za.ac.cput.service.AcademicInfoService;
import java.util.List;

@RestController
@RequestMapping("/academicInfo")
public class AcademicInfoController {
    @Autowired
    private AcademicInfoService academicInfoService;

    @PostMapping("/create")
    public AcademicInfo create(@RequestBody AcademicInfo academicInfo) {
        return academicInfoService.create(academicInfo);
    }

    @GetMapping("/read/{academicID}")
    public AcademicInfo read(@PathVariable String academicID) {
        return academicInfoService.read(academicID);
    }

    @PutMapping("/update")
    public AcademicInfo update(@RequestBody AcademicInfo academicInfo) {
        return academicInfoService.update(academicInfo);
    }

    @DeleteMapping("/delete/{academicID}")
    public void delete(@PathVariable String academicID) {
        academicInfoService.delete(academicID);
    }

    @GetMapping("/getAll")
    public List<AcademicInfo> getAll() {
        return academicInfoService.getAllAcademicInfo();
    }
}
