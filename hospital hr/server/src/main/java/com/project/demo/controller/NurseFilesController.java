package com.project.demo.controller;

import com.project.demo.entity.NurseFiles;
import com.project.demo.service.NurseFilesService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 护士档案：(NurseFiles)表控制层
 *
 */
@RestController
@RequestMapping("/nurse_files")
public class NurseFilesController extends BaseController<NurseFiles, NurseFilesService> {

    /**
     * 护士档案对象
     */
    @Autowired
    public NurseFilesController(NurseFilesService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
