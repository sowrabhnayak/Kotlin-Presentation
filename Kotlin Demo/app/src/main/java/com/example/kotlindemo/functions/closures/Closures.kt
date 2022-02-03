package com.example.kotlindemo.functions.closures

abstract class Component
class Directory(containerName: String, vararg val component: Component) : Component()
class FileDetails(val fileName: String): Component()

class Closures {

    fun Component.extractAllFilesDetails(): List<FileDetails> {
        val fileDetails = mutableListOf<FileDetails>()

        /**
         * Need not keep this function outside and make it private if only limited functionality
         */
        fun extractAllFileDetails(c: Component) {
            if (c is FileDetails) {
                fileDetails.add(c)
            } else if (c is Directory) {
                c.component.forEach {
                    extractAllFileDetails(it)
                }
            } else {
                error("Unknown Container Type: $c")
            }
        }

        extractAllFileDetails(this)
        return fileDetails
    }

    /**
     * Eg function:
     */
    fun constructFolders(): Component {
        return Directory("Main Directory",
                    Directory("Profile",
                        FileDetails("personal_details.txt"),
                        FileDetails("username_password.txt")
                    ),
                    Directory("Documents",
                        FileDetails("pu_marks_card.pdf"),
                        FileDetails("graduation_certificate.pdf")
                    )
        )
    }

    fun getAllFilesInMainDirectory() = constructFolders().extractAllFilesDetails()
    val allFilesInMainDiectory = constructFolders().extractAllFilesDetails()
}