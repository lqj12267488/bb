package cn.itcast.controller;

import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/find")
    public String find(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "3") Integer pageSize) {
        PageInfo<Order> info = orderService.findAllOrder(pageNum, pageSize);
        model.addAttribute("order",info);
        //System.out.println(list);
       // System.out.println(info);
        return "/order/order-list";
    }

    @RequestMapping(value = "/delete")
    public String del(Integer id) {
        orderService.deleteOrder(id);
        return "redirect:/order/find";
    }

    @RequestMapping(value = "/addOrder")
    public String add(Order order){
        orderService.addOrder(order);
        return "redirect:/order/find";
    }

    @RequestMapping(value = "/addOrderUI")
    public String addUI() {
        return "/order/order-add";
    }
}
