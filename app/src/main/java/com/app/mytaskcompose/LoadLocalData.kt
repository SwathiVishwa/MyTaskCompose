package com.app.mytaskcompose

import com.app.mytaskcompose.model.NotificationList
import com.app.mytaskcompose.model.ProjectList

object LoadLocalData {
    private var projectTitle1 = "Real Estate Website Design"
    private var projectTitle2 = "Finance Mobile App Design & Dev"
    private var status = "Completed"
    private var project1 = "Mobile App Wireframe"
    private var project2 = "Real Estate App Design"
    private var project3 = "Dashboard & App Design"

    private var comment ="left a comment in task"
    private var userName =" Olivia Anna"
    private var userName1 =" Robert Brown"
    private var userName2 =" Anna"
    private var userName3 =" Sophiya"

    private fun userList(): ArrayList<Int> {
        val images: ArrayList<Int> = arrayListOf()
        images.add(R.drawable.ic_girl_user)
        images.add(R.drawable.ic_boy_user)
        images.add(R.drawable.ic_girl_user)
        images.add(R.drawable.ic_boy_user)
        images.add(R.drawable.ic_girl_user)
        return images
    }

    fun projectList(): ArrayList<ProjectList> {
        val list: ArrayList<ProjectList> = arrayListOf()
        for (i in 0..3) {
            list.add(ProjectList(projectTitle1, status, userList()))
            list.add(ProjectList(projectTitle2, status, userList()))
        }
        return list
    }

    fun ongoingProjects(): ArrayList<ProjectList> {
        val ongoingList: ArrayList<ProjectList> = arrayListOf()
        for (i in 0..1) {
            ongoingList.add(ProjectList(project1, status, userList()))
            ongoingList.add(ProjectList(project2, status, userList()))
            ongoingList.add(ProjectList(project3, status, userList()))
        }
        return ongoingList
    }

    fun notificationList():ArrayList<NotificationList>{
        val notificationList:ArrayList<NotificationList> = arrayListOf()
        notificationList.add(NotificationList(R.drawable.ic_girl_user, projectTitle1,comment,userName))
        notificationList.add(NotificationList(R.drawable.ic_boy_user, projectTitle2,comment,userName1))
        notificationList.add(NotificationList(R.drawable.ic_girl_user, project1,comment,userName2))
        notificationList.add(NotificationList(R.drawable.ic_boy_user, projectTitle1,comment,userName3))
        notificationList.add(NotificationList(R.drawable.ic_girl_user, project2,comment,userName))
        notificationList.add(NotificationList(R.drawable.ic_boy_user, projectTitle1,comment,userName3))
        notificationList.add(NotificationList(R.drawable.ic_girl_user, project2,comment,userName2))
        return notificationList
    }
}