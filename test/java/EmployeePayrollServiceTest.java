import com.EmployeePayrollData;
import com.EmployeePayrollService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeePayrollServiceTest {
    EmployeePayrollService employeePayrollService;
    @Before
    public void initialize()
    {
        EmployeePayrollData[] arrayOfEmps = {
                new EmployeePayrollData(1, "Amar", 100.0),
                new EmployeePayrollData(2, "AKBAR", 200.00)
        };

        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
    }
    @Test
    public void given3EmployeeWhenWrittenToFileShouldMatchEmployeeEntries()
    {
        employeePayrollService.writeData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        assertEquals(2,entries);
    }
}
