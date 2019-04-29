<b>what is protocolbuff?</b><br/>
Protocol Buffers is a method of serializing structured data. It is useful in developing programs to communicate with each other over a wire or for storing data. 

<b>features of protobuff</b>:- 
1. They are a simple interface for serializing structured data.
2. They are 3 to 10 times smaller than XML.
3. They are 20 to 100 times faster than XML to parse and serialize.
4. The protoc compiler generates easy-to-use data classes in many client languages.
5. Where browsers and JavaScript are not consuming the data directly – particularly in the case of internal services – it’s my opinion that structured formats, such as Google’s Protocol Buffers, are a better choice than JSON for encoding data. 
6. In Protocol buffer new fields could be easily introduced, and intermediate servers that didn’t need to inspect the data could simply parse it and pass through the data without needing to know about all the fields.
7. Because Protocol Buffers are implemented in a variety of languages, they make interoperability between polyglot applications in your architecture that much simpler.

So, Protocol Buffers offer several compelling advantages over JSON for sending data over the wire between internal services. While not a wholesale replacement for JSON, especially for services which are directly consumed by a web browser, Protocol Buffers offers very real advantages, typically in terms of speed of encoding and decoding, size of the data on the wire, and more.

<b>How it works?</b>

To support Protobuf, first a PROTO file is needed. This file described the base format of the data to be shared, and this file is shared (or duplicated) across the various entities (e.g. the Webservice, the client App e.g. Android) that uses it. It could be viewed as a contract across the entities.
The PROTO file is then used to generate the Proto classes of specific language (e.g. for Android it is Java). This is done through the PROTOC tool. You could do that external to Android Studio and copy the generated file over to be used in your code. 

<b>PROTO file (PROTOC compiler generates) -> proto java class -> App module</b>

<b>when we should use protobuff?</b>
as the company grows and our data also becomes complex and our application is storing data to our disk or transmitting it over a network,the structure of the data should be clear. Schemas describe and document data models.
so, protocol buffers are used to built a great schema language.
1. it's cross platform and language independent JSON is also.so we can use proto schemas with any programming language.
2. Proto schemas are future-proof means we can evolve our schema as our application loses or gains new ones.
3. it is mostly used with internal api's calls.
4. Protocol Buffers also defines a compact binary encoding of messages that conform to the schema. This encoding is fast to encode, fast to decode, small to transmit, and small to store. The binary encoding uses numeric tags from the schema, like the 5 for period above.

<b>Wire/protocol buffer is used to parse protocol buffers like GSON and moshi used to parse JSON but wire/protocol buffers is very fast compsred to GSON.
why use Wire - features?</b>
1. Wire messages declare public final fields instead of the usual getter methods. This cuts down on both code generated and code executed. Less code is particularly beneficial for Android programs.

2. Wire avoids case mapping. A field declared as picture_urls in a schema yields a Java field picture_urls and not the conventional pictureUrls camel case. Though the name feels awkward at first, it's fantastic whenever you use grep or more sophisticated search tools. No more mapping when navigating between schema, Java source code, and data. It also provides a gentle reminder to calling code that proto messages are a bit special.

3.Primitive types are always boxed. If a field is absent, its value is null.



references:-
1. https://github.com/square/wire
2. https://proandroiddev.com/how-to-setup-your-android-app-to-use-protobuf-96132340de5c
3. https://codeclimate.com/blog/choose-protocol-buffers/
4. https://medium.com/@elye.project/simple-android-protobuf-tutorial-with-actual-code-bfb581299f47
5. https://developers.google.com/protocol-buffers/docs/proto3
6. https://medium.com/@anandbose/bye-bye-json-welcome-protocol-buffers-a3e4319ba51

Protocol buffer in code.how protocol buffers looks in code
ex:-

syntax = "proto3";<br/>
message Greeting {<br/>
    string status = 1; <br/>
    string message = 2;<br/>
}<br/>

The syntax = "proto3"; sentence tells the compiler that you’re using the version 3 of protocol buffers. In the message body, you can define the fields associated with the message. It supports unsigned and signed integers, floats, doubles, byte-arrays, strings, booleans, enums and user defined messages. In the above example, don’t confuse it like assigning a number to a string. It’s just field numbers, that represent the order of those fields in serialized data.

<b>How to install protocol buffer(means create a proto file)</b> <br/>
run this command (where u have your jar file like in proto directory so run this command there) :- <br/>

java -jar wire-compiler-2.1.1-jar-with-dependencies.jar \
    --proto_path=proto-repository \
    --java_out=../main/java/ \
    --files=Sample.include
<br/>
<img src="">
