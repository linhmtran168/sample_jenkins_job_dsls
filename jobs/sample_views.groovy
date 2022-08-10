listView('Generated Jobs') {
    jobs {
        regex(/.*test-job.*/)
    }
    recurse(true)
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
    }
}
