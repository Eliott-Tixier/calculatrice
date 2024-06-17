package et.calculatorbackend.Services;

import et.calculatorbackend.Entity.Operation;
import et.calculatorbackend.Repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    @Autowired
    private OperationRepository operationRepository;

    public Operation performOperation(int operand1, int operand2, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand2 != 0 ? operand1 / operand2 : 0; // handle division by zero
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        Operation operation = new Operation(operand1, operand2, operator, result);
        return operationRepository.save(operation);
    }

    public List<Operation> getLastFiveOperations() {
        return operationRepository.findTop5ByOrderByTimestampDesc();
    }
}
