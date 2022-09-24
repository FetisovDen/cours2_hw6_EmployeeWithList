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
        this.employeeService = employeeService;}


    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) {
        return employeeService.addEmployee(firstName,lastName);
    }
    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) {
        return employeeService.removeEmployee(firstName,lastName);
    }
    @GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) {
        return employeeService.containsEmployee(firstName,lastName);
    }
    @GetMapping("/findAll")
    public String find() {
        return employeeService.findAll();
    }

}


