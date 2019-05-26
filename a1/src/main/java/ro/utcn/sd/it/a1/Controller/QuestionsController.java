package ro.utcn.sd.it.a1.Controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.it.a1.dto.QuestionDTO;
import ro.utcn.sd.it.a1.event.BaseEvent;
import ro.utcn.sd.it.a1.service.QuestionManagementService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionManagementService qms;
    private final SimpMessagingTemplate messagingTemplate;

    @GetMapping("/questions")
    public List<QuestionDTO> readAll() {
        return qms.listQuestion();
    }

    @PostMapping("/questions")
    /*
    public QuestionDTO create(@RequestBody QuestionDTO dto) {
        return qms.addQuestion(dto);
    }
    */

    public QuestionDTO create(@RequestBody QuestionDTO dto) {
        return qms.insert(dto);
    }

    @EventListener(BaseEvent.class)
    public void handleEvent(BaseEvent event) {
        log.info("Got an event: {}.", event);
        messagingTemplate.convertAndSend("/topic/events",event);

    }

}

