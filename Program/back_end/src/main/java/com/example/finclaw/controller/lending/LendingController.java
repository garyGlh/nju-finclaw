package com.example.finclaw.controller.lending;

import com.example.finclaw.bl.lending.LendingService;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.lending.LendingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: HX
 * @Date:   2021-2-2
 */
@RestController
@RequestMapping("/api/lending")
public class LendingController {

    @Autowired
    private LendingService lendingService;

    @PostMapping("/addLendingForm")
    public ResponseVO addLendingForm(@RequestBody LendingForm lendingForm){
        //银行可以浏览到在平台上借款的小微企业的借款列表，然后可以为某个借款请求提交贷款意愿，需要填写的信息见LendingForm
        return lendingService.addLendingForm(lendingForm);
    }

    @GetMapping("/getBankLendingHistory/{bankID}")
    public ResponseVO getBankLendingHistory(@PathVariable Integer bankID){
        //查看某银行在平台的所有贷款记录
        return lendingService.getBankLendingHistory(bankID);
    }

    @GetMapping("/getLendingHistory/{lendingHistoryID}")
    public ResponseVO getLendingHistory(@PathVariable Integer lendingHistoryID){
        //查看某条贷款记录
        return lendingService.getLendingHistory(lendingHistoryID);
    }

    @PostMapping("/setDealt/{lendingHistoryID}")
    public ResponseVO setDealt(@PathVariable Integer lendingHistoryID){
        //银行发布的贷款意愿被用户采纳后置为将hasDealt置为true
        return lendingService.setDealt(lendingHistoryID);
    }

}
