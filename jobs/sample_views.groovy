nestedView('Generated Jobs') {
    views {
        listView('overview') {
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
}