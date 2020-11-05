package de.dhbw.webeng.chat;

import de.dhbw.webeng.chat.view.Chat;
import de.dhbw.webeng.chat.view.ChatMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    private List<ChatMsg> chatHistory = new ArrayList<>();

    @GetMapping({"/", "/login"})
    public String login(Model model, @ModelAttribute("chat") Chat chat) {
        return "login";
    }

    @PostMapping({"/login"})
    public String sendLogin(Model model, @ModelAttribute("chat") Chat chat) {

        return "chat";
    }

    @GetMapping({"/chat"})
    public String chat(Model model, @ModelAttribute("chat") Chat chat) {
        return "chat";
    }

    @PostMapping({"/chat"})
    public String sendCHatMsg(Model model, @ModelAttribute("chat") Chat chat) {

        ChatMsg current = new ChatMsg();
        current.msg = chat.getMsg();
        current.user = chat.getUserName();
        chatHistory.add(current);

        chat.setHistory(chatHistory);
        chat.setMsg("");

        return "chat";
    }
}
