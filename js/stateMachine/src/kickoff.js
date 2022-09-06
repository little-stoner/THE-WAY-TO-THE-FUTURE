import { createMachine } from 'xstate';

const promiseMachine =
    /** @xstate-layout N4IgpgJg5mDOIC5QAcBOB7AtgS1mAdMmAHYTbFQDEASgKIDKA8gDIBqtiK6s2ALtumKcQAD0QBaAIwAGAOz4ArAA4AbLIAsk9SoBMAZj3S9OgDQgAnhJ0K9iybJULpK9QpcrnAX09m0WXAREpORUdABStADCACrCyNx8AkJIohIyOvjqDs7S0kp6KgCchdZmlghSCur4uioqSsqFkgqyOjrePiDE6BBwcRg4eIQkZBRxCfyCwmIVes34Sq5uHq2FKpJKZVa5mU066ppGSjKF3r4DAfiocOgANgBukOM8k8mgMzLyssZrhXrfqnUOk2FisHnw0h0zRKqmMVVcZxAfkGBGuACswABjXhPFLxF5JaaIGRKOxA9R6JzOCnNLYVSTrfCSQwKP46b6tVySRHIy4AV2IAGtugB3N5IiaElIzKTWBYadT5b4GWTFUygioKBQQopyZl5JTApSnTq8vDPRJTaUSAyFBZLOpyHRrDZ08QGDJqwraDR6EoqPQdTxAA */
    createMachine(
        {
            context: {},
            id: "promise",
            initial: "pending",
            states: {
                pending: {
                    on: {
                        RESOLVE: {
                            target: "resolved",
                        },
                        REJECT: {
                            target: "rejected",
                        },
                    },
                },
                resolved: {
                    type: "final",
                },
                rejected: {
                    type: "final",
                },
                unknown: {},
            },
        },
        {
            actions: {},
            delays: {},
            guards: {},
            services: {}
        }
    );

