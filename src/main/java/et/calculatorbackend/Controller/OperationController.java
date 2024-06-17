package et.calculatorbackend.Controller;

import et.calculatorbackend.Entity.Operation;
import et.calculatorbackend.Services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OperationController {
    @Autowired
    private OperationService calculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<Operation> calculate(
            @RequestParam int operand1,
            @RequestParam int operand2,
            @RequestParam String operator) {
        Operation operation = calculatorService.performOperation(operand1, operand2, operator);
        return ResponseEntity.ok(operation);
    }

    @GetMapping("/last5")
    public ResponseEntity<List<Operation>> getLastFiveOperations() {
        List<Operation> operations = calculatorService.getLastFiveOperations();
        return ResponseEntity.ok(operations);
    }
}
