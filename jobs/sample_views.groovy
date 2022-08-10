views {
    listView('Generated Jobs') {
        jobs {
            regex(/test-job.*/)
        }
        columns {
            status()
            weather()
            name()
            lastSuccess()
            lastFailure()
        }
    }
}