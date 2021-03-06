package com.magnus.project.managee.work.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TeamBusinessMapper {

    @Insert("insert into managee_team_business(team_id, business_id, team_role) value(#{teamId},#{businessId},#{role})")
    public void insertBusinessTeam(int teamId, int businessId, int role);

    @Delete("delete from managee_team_business where team_id=#{teamId} and business_id=#{businessId}")
    public void deleteTeamBusiness(int teamId, int businessId);

    @Delete("delete from managee_team_business where business_id=#{businessId}")
    public void deleteTeamBusinessByBusinessId(int businessId);

    @Insert("insert into managee_business_pre_evaluate_team values(#{businessId}, #{teamId}, #{status})")
    public void insertBusinessEvaluateTeam(int businessId, int teamId, int status);

    @Update("update managee_business_pre_evaluate_team set evaluate_status=4 and evaluate_feedback=#{feedback} where business_id=#{businessId} and team_id=#{teamId}")
    public void updateBusinessEvaluateTeamAsDecline(int businessId, int teamId, String feedback);

    @Select("select * from managee_business_pre_evaluate_team where business_id=#{businessId}")
    public void selectBusinessEvaluateTeam(int businessId);

    @Insert("insert into managee_team_business(business_id, team_id, status) value(#{businessId}, #{teamId}, #{status})")
    public void insertBusinessTeamAsTest(int businessId, int teamId, int status);

    @Update("update managee_team_business set status=#{status} where business_id=#{businessId}")
    public void updateBusinessTeamTestStatus(int businessId, int status);

    @Select("select team_role from managee_team_business where business_id=#{businessId} and team_id=#{teamId}")
    public int selectTeamRoleInBusiness(int businessId, int teamId);
}