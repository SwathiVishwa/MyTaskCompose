package com.app.mytaskcompose

import com.app.mytaskcompose.model.ProjectList

object LoadLocalData {
    private var projectTitle1 = "Real Estate Website Design"
    private var projectTitle2 = "Finance Mobile App Design & Dev"
    private var status = "Completed"
    private var project1 = "Mobile App Wireframe"
    private var project2 = "Real Estate App Design"
    private var project3 = "Dashboard & App Design"

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
        for (i in 0..3) {
            ongoingList.add(ProjectList(project1, status, userList()))
            ongoingList.add(ProjectList(project2, status, userList()))
            ongoingList.add(ProjectList(project3, status, userList()))
        }
        return ongoingList
    }
}