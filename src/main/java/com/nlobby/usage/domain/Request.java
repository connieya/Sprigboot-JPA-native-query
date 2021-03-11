package com.nlobby.usage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "vst_visit_request")
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    private Long id;

//    @OneToMany(mappedBy = "request")
//    private List<Access> access;


//    @OneToMany(mappedBy = "request")
//    @JoinColumn(name = "visit_request_id")
//    private List<Access> accesses = new ArrayList<>();


    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Enumerated (EnumType.STRING)
    @Column(name = "visit_type")
    private VisitType visitType;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "checkin_dt")
    private Date checkinDate;

    @Column(name = "checkout_dt")
    private Date checkoutDate;



//    private String hash;
//
//    @Column(name = "country_code")
//    private String countryCode;

//    private String ssn;
//
    private String name;
//
//    private String company;
//
//    private String position;
//
//    private String phone;
//
//    @Column(name = "cell_phone")
//    private String cellPhone;
//
//    @Column(name = "accessible_place")
//    private Long accessiblePlace;
//
//    private Long purpose;
//
//    @Column(name = "has_car")
//    private boolean hasCar;
//
//    @Column(name = "car_kind_id")
//    private Long carKindId;
//
//    @Column(name = "car_model_id")
//    private Long carModelId;
//
//    @Column(name = "add_info1")
//    private String addInfo1;
//
//    @Column(name = "add_info2")
//    private String addInfo2;
//
//    @Column(name = "has_notebook")
//    private boolean hasNotebook;
//
//    @Column(name = "notebook_vendor")
//    private String notebookVendor;
//
//    @Column(name = "notebook_model")
//    private String notebookModel;
//
//    @Column(name = "notebook_serial")
//    private String notebookSerial;
//
//    private int violate;
//
//    @Column(name = "leader_id")
//    private Long leaderId;
//
//    @Column(name = "host_user_id")
//    private Long hostUserId;
//
//    @Column(name = "approver_id")
//    private Long approverId;
//
//    @Column(name = "status_code")
//    private String statusCode;
//
//    @Column(name = "last_status_code")
//    private String lastStatusCode;
//
//    @Column(name = "followers_cnt")
//    private int followersCnt;
//
//    private boolean completed;
//
//    @Column(name = "group_idx")
//    private Long groupIdx;
//
//    @Column(name = "register_id")
//    private Long registerId;
//
//    @Column(name = "desk_message")
//    private String deskMessage;
//
//    @Column(name = "reserve_no")
//    private String reserveNo;
//
//    @Column(name = "pass_id")
//    private Long passId;
//
//    @Column(name = "car_pass_id")
//    private Long carPassId;
//
//    @Column(name = "location_code")
//    private String locationCode;
//
//    private String email;
//
//    private String language;
//
//    @Column(name = "created_at")
//    private Timestamp createdAt;
//
//    @Column(name = "updated_at")
//    private Timestamp updatedAt;
//
//    @Column(name = "deleted_At")
//    private Timestamp deletedAt;
//
//    private boolean vip;
//
//    @Column(name = "did_body")
//    private String didBody;
//
//    @Column(name = "keeped_items")
//    private String keepedItems;
//
//    @Column(name = "carried_items")
//    private String carriedItems;
//
//    @Column(name = "returned_items")
//    private String returnedItems;
//
//    @Column(name = "qr_id")
//    private Long qrID;
//
//    @Column(name = "ipad_no")
//    private String ipadNo;
//
//    @Column(name = "target_num")
//    private Long targetNum;
//
//    private Long location;
//
//    @Column(name = "visit_place")
//    private String visitPlace;
//
//    @Column(name = "visit_purpose")
//    private String visitPurpose;
//
//    @Column(name = "remind_sms_date")
//    private Timestamp remindSmsDate;
//
//    @Column(name = "issue_pass_yn")
//    private boolean issuePassYn;
//
//    @Column(name = "coax_mail_send_yn")
//    private boolean coaxMailSendYn;
//
//    @Column(name = "web_type")
//    private String webType;
//
//    private String note;
//
//    @Column(name = "app_sys_id")
//    private String appSysId;
//
//    @Column(name = "app_sys_status")
//    private String appSysStatus;
//
//    @Column(name = "last_update")
//    private Timestamp lastUpdate;


    public Request(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
