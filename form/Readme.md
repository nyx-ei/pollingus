
# Markdown Syntax for Poll
Use the Markdown language to generate your survey

>* ### Add a survey header and description with:
```
# write the poll name here
## write the poll description

```
>* ### Add a partial question to the poll
```
#### write question title here
- yes
- no

```
>* ### Add multiple choice question to poll
```
#### write question title here
- [ ] valeur1
- [ ] valeur2
- [ ] valeur3
- [ ] valeur4

```
>* ### Add a coding question to the survey
```
#### write question title here
- [ ] `valeur1`
- [ ] `valeur2`
- [ ] `valeur3`
- [ ] `valeur4`

```
>* ### Add an affiliate question to another in the survey
```
[ affiliate=type ] write question title here
~ valeur1
~ valeur2
~ valeur3
~ valeur4
```
**N.B**: Here **type**, indicates the type of affiliate question. 

This type can be: coding, Yes/No, multiple choice, open, Likert scale...

Depending on the type, the values will be added or not.


>* ### Add an open-ended question to the poll
```
[ input ] write the title of the question here
```
>* ### Add a Likert question (for example to assess customer satisfaction)
```
#### question title
- Totally agree / Very satisfied
- Agree / Somewhat satisfied
- Neither agree nor disagree / Neither satisfied nor dissatisfied
- Disagree / Somewhat dissatisfied
- Totally disagree / Very dissatisfied

```
>* ### Add a random question (whose position of the proposals changes)
```
[ random ] write the title of the question here
 ** valeur1
 ** valeur2
 ** valeur3
 ** valeur4

 ```
