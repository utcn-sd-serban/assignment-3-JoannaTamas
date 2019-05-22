package ro.utcn.sd.it.a1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.it.a1.dto.QuestionDTO;
import ro.utcn.sd.it.a1.service.QuestionManagementSystem;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionManagementSystem qms;

    @GetMapping("/questions")
    public List<QuestionDTO> readAll() {
        return qms.listQuestion();
    }

    @PostMapping("/questions")
    public QuestionDTO create(@RequestBody QuestionDTO dto) {
        return qms.addQuestion(dto);
    }
}
