package com.interviews.interviews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewEvent {
    private String candidateName;
    private String technology;
    private String interviewDate;
    private String interviewRound;
}