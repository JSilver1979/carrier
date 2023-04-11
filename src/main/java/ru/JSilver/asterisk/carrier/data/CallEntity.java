package ru.JSilver.asterisk.carrier.data;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "calls")
public class CallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "call_id")
    private String callId;

    @Column(name = "number")
    private String number;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "call_time")
    private LocalTime callTime;

    @Column(name = "queue_time")
    private LocalTime queueTime;

    @Column(name = "wait_time")
    private LocalTime waitTime;

    @Column(name = "agent_number")
    private String agentNumber;

    @Column(name = "answer_time")
    private LocalTime answerTime;

    @Column(name = "answer_duration")
    private LocalTime answerDuration;

    @Column(name = "call_status")
    private String callStatus;

    @Column(name = "queue_status")
    private String queueStatus;

    @Column(name = "audio_path")
    private String audioPath;

    @Column(name = "redirected")
    private boolean isRedirected;

    @Column(name = "recall")
    private boolean isRecalled;

    @Column(name = "comment")
    private String comment;

    @Column(name = "queue_number")
    private String queueNumber;

    public CallEntity() {
    }

    public CallEntity(String callId, String number, LocalDate date, LocalTime callTime, LocalTime queueTime, LocalTime waitTime, String agentNumber, LocalTime answerTime, LocalTime answerDuration, String callStatus, String queueStatus, String audioPath, boolean isRedirected, boolean isRecalled, String comment, String queueNumber) {
        this.callId = callId;
        this.number = number;
        this.date = date;
        this.callTime = callTime;
        this.queueTime = queueTime;
        this.waitTime = waitTime;
        this.agentNumber = agentNumber;
        this.answerTime = answerTime;
        this.answerDuration = answerDuration;
        this.callStatus = callStatus;
        this.queueStatus = queueStatus;
        this.audioPath = audioPath;
        this.isRedirected = isRedirected;
        this.isRecalled = isRecalled;
        this.comment = comment;
        this.queueNumber = queueNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getCallTime() {
        return callTime;
    }

    public void setCallTime(LocalTime callTime) {
        this.callTime = callTime;
    }

    public LocalTime getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(LocalTime queueTime) {
        this.queueTime = queueTime;
    }

    public LocalTime getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(LocalTime waitTime) {
        this.waitTime = waitTime;
    }

    public String getAgentNumber() {
        return agentNumber;
    }

    public void setAgentNumber(String agentNumber) {
        this.agentNumber = agentNumber;
    }

    public LocalTime getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(LocalTime answerTime) {
        this.answerTime = answerTime;
    }

    public LocalTime getAnswerDuration() {
        return answerDuration;
    }

    public void setAnswerDuration(LocalTime answerDuration) {
        this.answerDuration = answerDuration;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public String getQueueStatus() {
        return queueStatus;
    }

    public void setQueueStatus(String queueStatus) {
        this.queueStatus = queueStatus;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public boolean isRedirected() {
        return isRedirected;
    }

    public void setRedirected(boolean redirected) {
        isRedirected = redirected;
    }

    public boolean isRecalled() {
        return isRecalled;
    }

    public void setRecalled(boolean recalled) {
        isRecalled = recalled;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(String queueNumber) {
        this.queueNumber = queueNumber;
    }
}
