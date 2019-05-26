package ro.utcn.sd.it.a1.command;

import ro.utcn.sd.it.a1.dto.QuestionDTO;

public interface Command {

    QuestionDTO execute (QuestionDTO dto);
}
