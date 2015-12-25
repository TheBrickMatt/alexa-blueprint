# Alexa Blueprint Skill
An Amazon Echo app blueprint that can help you get started with Alexa development.

## Building
The build requires the alexa-skills-kit jar, which is only available to registered Amazon application developers.
Once registered, download the AlexaSkillsKitJava.zip and build it according to the instructions.

That build will add the artifact to your local maven repo.
If you want to keep it locally, you can copy the repo contents from that project into the repo directory in this project.

To create a jar that can be loaded to Lambda, the typical maven command will look like:
```mvn assembly:assembly -DdescriptorId=jar-with-dependencies package```

## To deploy as a Lamba function
- Read the example section [Preparing a Java Sample to Deploy in Lambda](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/deploying-a-sample-skill-to-aws-lambda)

## Skill Configuration
See SKILL_INFO.md

## Resources
Links to the Alexa documentation
- [Amazon Apps and Services Developer Portal](https://developer.amazon.com/appsandservices/solutions/alexa/alexa-skills-kit/).
- [Using the Alexa Skills Kit Samples](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/using-the-alexa-skills-kit-samples)
- [Getting Started](https://developer.amazon.com/appsandservices/solutions/alexa/alexa-skills-kit/getting-started-guide)
- [Invocation Name Guidelines](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/choosing-the-invocation-name-for-an-alexa-skill)
- [Developing an Alexa Skill as an AWS Lambda Function](https://developer.amazon.com/appsandservices/solutions/alexa/alexa-skills-kit/docs/developing-an-alexa-skill-as-a-lambda-function)
