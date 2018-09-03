/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.processplatform.core.entity.content;

import com.x.base.core.entity.SliceJpaObject_;
import com.x.processplatform.core.entity.element.ActivityType;
import com.x.processplatform.core.entity.element.ManualMode;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.processplatform.core.entity.content.TaskCompleted.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Sun Sep 02 18:44:03 CST 2018")
public class TaskCompleted_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<TaskCompleted,String> activity;
    public static volatile SingularAttribute<TaskCompleted,String> activityAlias;
    public static volatile SingularAttribute<TaskCompleted,String> activityDescription;
    public static volatile SingularAttribute<TaskCompleted,String> activityName;
    public static volatile SingularAttribute<TaskCompleted,String> activityToken;
    public static volatile SingularAttribute<TaskCompleted,ActivityType> activityType;
    public static volatile SingularAttribute<TaskCompleted,String> application;
    public static volatile SingularAttribute<TaskCompleted,String> applicationAlias;
    public static volatile SingularAttribute<TaskCompleted,String> applicationName;
    public static volatile SingularAttribute<TaskCompleted,Boolean> completed;
    public static volatile SingularAttribute<TaskCompleted,Date> completedTime;
    public static volatile SingularAttribute<TaskCompleted,String> completedTimeMonth;
    public static volatile SingularAttribute<TaskCompleted,String> creatorIdentity;
    public static volatile SingularAttribute<TaskCompleted,String> creatorPerson;
    public static volatile SingularAttribute<TaskCompleted,String> creatorUnit;
    public static volatile SingularAttribute<TaskCompleted,Long> duration;
    public static volatile SingularAttribute<TaskCompleted,Date> expireTime;
    public static volatile SingularAttribute<TaskCompleted,Boolean> expired;
    public static volatile SingularAttribute<TaskCompleted,String> id;
    public static volatile SingularAttribute<TaskCompleted,String> identity;
    public static volatile SingularAttribute<TaskCompleted,String> job;
    public static volatile SingularAttribute<TaskCompleted,Boolean> latest;
    public static volatile SingularAttribute<TaskCompleted,ManualMode> manualMode;
    public static volatile SingularAttribute<TaskCompleted,String> opinion;
    public static volatile SingularAttribute<TaskCompleted,String> opinionLob;
    public static volatile SingularAttribute<TaskCompleted,String> person;
    public static volatile SingularAttribute<TaskCompleted,String> process;
    public static volatile SingularAttribute<TaskCompleted,String> processAlias;
    public static volatile SingularAttribute<TaskCompleted,String> processName;
    public static volatile SingularAttribute<TaskCompleted,ProcessingType> processingType;
    public static volatile SingularAttribute<TaskCompleted,Date> retractTime;
    public static volatile SingularAttribute<TaskCompleted,String> routeName;
    public static volatile SingularAttribute<TaskCompleted,String> serial;
    public static volatile SingularAttribute<TaskCompleted,Date> startTime;
    public static volatile SingularAttribute<TaskCompleted,String> startTimeMonth;
    public static volatile SingularAttribute<TaskCompleted,String> task;
    public static volatile SingularAttribute<TaskCompleted,String> title;
    public static volatile SingularAttribute<TaskCompleted,String> unit;
    public static volatile SingularAttribute<TaskCompleted,String> work;
    public static volatile SingularAttribute<TaskCompleted,String> workCompleted;
}
