folderName = 'otherjobs'

folder(folderName) {
    description('Other Jobs')
}

job = freeStyleJob("$folderName/test-job-2")
job.with {
    description('GENERATED JOB 2 - MANUAL CHANGES WILL BE OVERWRITTEN')
    wrappers {
        colorizeOutput()
    }
}

job.with {
    logRotator {
        numToKeep(5)
    }
}

job.with {
    steps {
        shell 'echo test super other job'
    }
}

job.with {
    publishers {
        slackNotifier {
            room('Dev Team B')
            notifyAborted(true)
            notifyFailure(true)
            notifyNotBuilt(true)
            notifyUnstable(true)
            notifyBackToNormal(true)
            notifySuccess(false)
            notifyRepeatedFailure(false)
            startNotification(false)
            includeTestSummary(false)
            includeCustomMessage('ABC 134')
            commitInfoChoice('NONE')
            tokenCredentialId('slack-token')
        }
    }
}
