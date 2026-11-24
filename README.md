# Rheo

A small Unix-style shell written from scratch in Java, as a way to learn how shells actually work: reading input, parsing it into a command, running built-ins in-process and starting everything else as a child process.

```text
rheo /Users/me/projects> pwd
/Users/me/projects
rheo /Users/me/projects> ls -la
...
rheo /Users/me/projects> exit 0
```

## What it does

- **A REPL** with a prompt that shows the current directory
- **Built-ins** that run inside the shell: `cd` (with no argument it goes home), `pwd`, `exit [code]`
- **External commands** run through `ProcessBuilder`, with the terminal's stdin, stdout and stderr passed straight through
- `rheo: command not found: …` when a command doesn't exist

## How it works

```
input ─► CommandParser ─► Command(name, args) ─┬─► BuiltinCommand   (cd, pwd, exit)
                                               └─► CommandExecutor  (child process)
```

| File | Role |
|---|---|
| `Shell.java` | The main loop: read, parse, dispatch |
| `CommandUtils.java` | Prompt and input |
| `CommandParser.java` | Splits input on whitespace into a name and arguments |
| `Command.java` | The parsed command |
| `BuiltinCommand.java` | Built-in commands that run in the shell's own process |
| `CommandExecutor.java` | Starts external programs and waits for them to finish |

## Run it

Needs Java 17+ and Maven.

```bash
mvn package
java -jar target/rheo-*.jar
```

## Roadmap

- [ ] Run external commands in the directory `cd` moved to (`ProcessBuilder.directory`)
- [ ] Quoted arguments (`echo "hello world"`)
- [ ] Pipes (`ls | grep java`)
- [ ] Redirection (`>`, `>>`, `<`)
- [ ] Environment variables (`$HOME`, `export`)
- [ ] History and Ctrl+C handling
