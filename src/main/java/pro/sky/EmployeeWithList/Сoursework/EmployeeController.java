package pro.sky.EmployeeWithList.Сoursework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public String add(@RequestParam("id") String id,
                      @RequestParam("fullName") String fullName,
                      @RequestParam("salary") double salary,
                      @RequestParam("department") int department) {
        return employeeService.addEmployee(id, fullName, salary, department);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") String id) {
        return employeeService.removeEmployee(id);
    }

    @GetMapping("/find")
    public String find(@RequestParam("id") String id) {
        return employeeService.containsEmployee(id);
    }

    @GetMapping("/findAll")
    public String find() {
        return employeeService.findAll();
    }

}


