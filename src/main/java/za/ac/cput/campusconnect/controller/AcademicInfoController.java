package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.AcademicInfo;
import za.ac.cput.service.AcademicInfoService;

import java.util.List;

@RestController
@RequestMapping("/academic-info")
public class AcademicInfoController {

    private final AcademicInfoService academicInfoService;

    @Autowired
    public AcademicInfoController(AcademicInfoService academicInfoService) {
        this.academicInfoService = academicInfoService;
    }

    @PostMapping("/create")
    public ResponseEntity<AcademicInfo> createAcademicInfo(@RequestBody AcademicInfo academicInfo) {
        AcademicInfo createdAcademicInfo = academicInfoService.create(academicInfo);
        return new ResponseEntity<>(createdAcademicInfo, HttpStatus.CREATED);
    }

    @GetMapping("/read/{academicID}")
    public ResponseEntity<AcademicInfo> getAcademicInfo(@PathVariable String academicID) {
        AcademicInfo academicInfo = academicInfoService.read(academicID);
        if (academicInfo != null) {
            return new ResponseEntity<>(academicInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<AcademicInfo> updateAcademicInfo(@RequestBody AcademicInfo academicInfo) {
        AcademicInfo updatedAcademicInfo = academicInfoService.update(academicInfo);
        return new ResponseEntity<>(updatedAcademicInfo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{academicID}")
    public ResponseEntity<Void> deleteAcademicInfo(@PathVariable String academicID) {
        academicInfoService.delete(academicID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AcademicInfo>> getAllAcademicInfo() {
        List<AcademicInfo> academicInfoList = academicInfoService.getAllAcademicInfo();
        return new ResponseEntity<>(academicInfoList, HttpStatus.OK);
    }
}
