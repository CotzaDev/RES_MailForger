# RES_MailForger

## Install a mock SMTP server for testing

Maybe you want to experiment with this tool before starting to really
send pranks mails.

To do so you can install a mock SMTP server.
In our case we will use [MailDev](https://github.com/djfarrelly/MailDev):
A simple smtp mail server built on top of NodeJS.
It provide a web interface to easily preview your email
and even relay them to a real smtp server.

![Screen of MailDev](https://camo.githubusercontent.com/94b7d9ba723ea19ac11f02c402dd9f1c84aff252/68747470733a2f2f646c2e64726f70626f7875736572636f6e74656e742e636f6d2f752f35303632373639382f6d61696c6465762f73637265656e73686f742d323031352d30332d32392e706e67)

### What is Mocking

Let’s try a definition:

> Service Mocking, or simulation, is the practice of creating a
> facsimile environment that works similar to the environment
> you’re facsimileing.

That’s fancy speak for saying "You build something
that works as something else".

So you should use mocks when you can’t use the real thing.

In our case we use a custom local SMTP server that will save all
the mails sent to it. In this way we can easily verify those mails
instead of flooding some email addresses during our testing.

### Install MailDev

#### Requirement

* [NodeJS](https://nodejs.org/en/download/)

#### Install

To install MailDev launch the following command in your terminal:

`npm install -g maildev`

#### Use

To run MailDev simply use the following command in your terminal:

`maildev`

If you want to be able to relay your mail to a real smtp sever you
can run it with the following parameter:

`maildev --outgoing-host smtp.domain.tld`

To see all the other parameters just use:

`maildev -h`
