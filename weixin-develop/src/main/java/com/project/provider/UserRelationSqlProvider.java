package com.project.provider;

import com.project.common.sql.SqlUtil;
import com.project.common.util.LogUtil;
import com.project.model.sql.UserRelation;
import com.project.model.vo.Page;
import org.apache.commons.logging.Log;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by goforit on 2017/12/3.
 */
public class UserRelationSqlProvider {

    private Log logger = LogUtil.getLogger(UserSqlProvider.class);

    /**
     * 插入语句
     * @param userRelation
     * @return
     */
    public String insert(final UserRelation userRelation){
        String sql = new SQL() {{

            INSERT_INTO("User_Relation");
            if (userRelation.getIntroducer() != null) {
                VALUES("introducer", "#{introducer}");
                VALUES("introducername", "#{introducername}");
            }
            if (userRelation.getNewmember() !=null){
                VALUES("newmember", "#{newmember}");
                VALUES("newmembername", "#{newmembername}");
            }
            VALUES("releation", "#{releation}");
            VALUES("lmodify", "#{lmodify}");
        }}.toString();
        return SqlUtil.relaceInto(sql);
    }


    /**
     *分页语句
     * @param page
     * @return
     */
    public String selectPageList(Page page){
        return new SQL(){{
            SELECT("newmember, newmembername, introducer, introducername, lmodify");
            FROM("User_Relation");
            ORDER_BY("lmodify desc limit #{start},#{row}");
        }}.toString();
    }

    /**
     * count语句
     * @return
     */
    public String selectPageListCount(){
        return new SQL(){{
            SELECT("count(1)");
            FROM("User_Relation");
        }}.toString();
    }

    /**
     *分页语句 PageHelper
     * @return
     */
    public String selectList(){
        return new SQL(){{
            SELECT("introducer, newmember, releation, lmodify, introducername, newmembername");
            FROM("User_Relation");
            ORDER_BY("lmodify desc");
        }}.toString();
    }

    /**
     * update
     * @param userRelation
     * @return
     */
    public String update(final UserRelation userRelation){
        String sql = new SQL() {{

            UPDATE("User_Relation");
            if (userRelation.getIntroducer() != null) {
                SET("introducer=#{introducer}");
            }
            if(userRelation.getIntroducername() != null) {
                SET("introducername=#{introducername}");
            }
            if (userRelation.getNewmember() != null){
                SET("newmember=#{newmember}");
            }
            if (userRelation.getNewmembername() != null) {
                SET("newmembername=#{newmembername}");
            }
            if (userRelation.getLmodify() != null) {
                SET("lmodify=#{lmodify}");
            }
            if (userRelation.getReleation() != 0) {
                SET("releation=#{releation}");
            }

            WHERE("id=#{id}");

        }}.toString();
        return SqlUtil.relaceInto(sql);
    }
}
