folderName = 'myjobs'

folder(folderName) {
    description('My Jobs')
}

job = freeStyleJob("$folderName/test-job")
job.with {
    description('GENERATED JOB - MANUAL CHANGES WILL BE OVERWRITTEN')
    wrappers {
        colorizeOutput()
    }
}

job.with {
    logRotator {
        numToKeep(30)
    }
}

job.with {
    steps {
        shell 'echo test linh dep trai 123'
    }
}

job.with {
    publishers {
        slackNotifier {
            room('Dev Team A')
            notifyAborted(true)
            notifyFailure(true)
            notifyNotBuilt(true)
            notifyUnstable(true)
            notifyBackToNormal(true)
            notifySuccess(false)
            notifyRepeatedFailure(false)
            startNotification(false)
            includeTestSummary(false)
            includeCustomMessage(false)
            commitInfoChoice('NONE')
            tokenCredentialId('slack-token')
        }
    }
}
