package com.survey.controller;

import com.survey.dto.ResponseDTO;
import com.survey.dto.SurveyDTO;
import com.survey.dto.survey.SurveyCreateByUserRequestDto;
import com.survey.dto.survey.SurveyCreateByUserResponseDto;
import com.survey.dto.survey.question.QuestionCreateRequestDto;
import com.survey.dto.survey.question.QuestionCreateResponseDto;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.QuestionService;
import com.survey.service.SurveyService;
import com.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
@CrossOrigin("*")
@Slf4j
public class SurveyController {

    private final UserService userService;
    private final SurveyService surveyService;
    private final QuestionService questionService;


    // 설문지 생성
//    @PostMapping("{userId}")
//    @ResponseBody
//    public SurveyCreateByUserResponseDto createSurvey(@PathVariable("userId") Integer userId
//            , @RequestBody SurveyCreateByUserRequestDto dto) {
//
//        // user 존재 유무 판단
//        User user = userService.getUser(userId);
//
//        // survery create
//        Survey survey = surveyService.createSurvey(dto, user);
//
//        SurveyCreateByUserRequestDto surveryInfoInDB = SurveyCreateByUserRequestDto.builder()
//                .surveyName(survey.getSurveyName())
//                .required(survey.getRequired())
//                .build();
//
//        SurveyCreateByUserResponseDto responseDto = SurveyCreateByUserResponseDto.builder()
//                .msg("survey create success !")
//                .userId(user.getUserId())
//                .surveyId(survey.getSurveyId())
//                .requestData(surveryInfoInDB)
//                .publishState(survey.getPublishState())
//                .publishStart(survey.getPublishStart())
//                .build();
//
//        return responseDto;
//    }

    // 질문지 생성
//    @PostMapping("{userId}/{surveyId}")
//    @ResponseBody
//    public QuestionCreateResponseDto createQuestion(@PathVariable("userId") Integer userId
//            , @PathVariable("surveyId") Integer surveyId
//            , @RequestBody QuestionCreateRequestDto dto) {
//
//        // user 존재 유무 판단
//        User user = userService.getUser(userId);
//
//        // user가 생성한 survery 존재 유무 판단
//        Survey survey = surveyService.getSurveyByUser(surveyId, userId);
//
//        // question create
//        Question question = questionService.createQuestion(dto, survey);
//
//        QuestionCreateRequestDto questionInfoInDB = QuestionCreateRequestDto.builder()
//                .questionContent(question.getQuestionContent())
//                .build();
//
//        QuestionCreateResponseDto responseDto = QuestionCreateResponseDto.builder()
//                .msg("survey's question create success !")
//                .userId(user.getUserId())
//                .surveyId(question.getSurvey().getSurveyId())
//                .questionId(question.getQuestionId())
//                .requestData(questionInfoInDB)
//                .build();
//
//        return responseDto;
//    }


    @GetMapping
    public ResponseEntity<?> findall() {
        List<Survey> categories = surveyService.findAll();
        List<SurveyDTO> dtos = categories.stream().map(SurveyDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

     @PostMapping("/add") // 설문조사 추가
     public ResponseEntity<?> save(@RequestBody SurveyDTO surveyDTO){ // 설문조사 추가
         try{
             User user = userService.findById(surveyDTO.getUserId());

             Survey survey = Survey.builder()
                     .surveyName(surveyDTO.getSurveyName())
                     .publishEnd(surveyDTO.getPublishEnd())
                     .publishStart(surveyDTO.getPublishStart())
                     .publishState(surveyDTO.getPublishState())
                     .required(surveyDTO.getRequired())
                     .user(user).build();

             Survey addSurvey = surveyService.save(survey);
             SurveyDTO responseSurveyDTO = SurveyDTO.builder()
                     .surveyId(addSurvey.getSurveyId())
                     .surveyName(addSurvey.getSurveyName())
                     .publishStart(addSurvey.getPublishStart())
                     .publishEnd(addSurvey.getPublishEnd())
                     .publishState(addSurvey.getPublishState())
                     .required(addSurvey.getRequired()).build();
             return ResponseEntity.ok(responseSurveyDTO);

         }catch (Exception e) {
             ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
             return ResponseEntity.badRequest().body(responseDTO);
         }
     }

    @PatchMapping("/update") // 설문조사 정보 수정
    public ResponseEntity<?> update(@RequestBody SurveyDTO surveyDTO){

        try{
            Survey survey =surveyService.update(surveyDTO);

            SurveyDTO responseSurveyDTO = SurveyDTO.builder()
                    .surveyId(survey.getSurveyId())
                    .surveyName(survey.getSurveyName())
                    .publishStart(survey.getPublishStart())
                    .publishEnd(survey.getPublishEnd())
                    .publishState(survey.getPublishState())
                    .required(survey.getRequired()).build();
            return ResponseEntity.ok(responseSurveyDTO);

        }catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @GetMapping("/all") // 특정 사용자의 설문조사 리스트 조회
    public ResponseEntity<?> findAllByUser(@RequestParam Long id){
        return surveyService.findAllByUser(id);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSurvey(@RequestBody SurveyDTO surveyDTO){
        try {
            List<Survey> surveyList = surveyService.deleteSurvey(surveyDTO);
            List<SurveyDTO> dtos = surveyList.stream().map(SurveyDTO::new).collect(Collectors.toList());
            return ResponseEntity.ok(dtos);

        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }

    }
}
